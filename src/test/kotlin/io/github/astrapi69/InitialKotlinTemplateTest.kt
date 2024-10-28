package io.github.astrapi69

import io.github.astrapi69.file.delete.DeleteFileExtensions
import io.github.astrapi69.file.modify.ModifyFileExtensions
import io.github.astrapi69.file.modify.api.FileChangeable
import io.github.astrapi69.file.search.PathFinder
import io.github.astrapi69.gradle.migration.extension.DependenciesExtensions
import io.github.astrapi69.gradle.migration.info.CopyGradleRunConfigurations
import io.github.astrapi69.gradle.migration.info.DependenciesInfo
import io.github.astrapi69.gradle.migration.runner.GradleRunConfigurationsCopier
import io.github.astrapi69.io.file.filter.PrefixFileFilter
import io.github.astrapi69.throwable.RuntimeExceptionDecorator
import io.github.astrapi69.throwable.api.ThrowableNoArgumentConsumer
import java.io.File
import java.io.IOException
import java.lang.Exception
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class InitialKotlinTemplateTest {
  @Test
  @Disabled
  @Throws(IOException::class)
  fun testRenameToConcreteProject() {
    var projectDescription: String?
    // TODO change the following description with your project description
    // and then remove the annotation Disabled and run this unit test method
    projectDescription = "!!!Chage this description with your project description!!!"
    renameToConcreteProject(projectDescription)
  }

  @Throws(IOException::class)
  private fun renameToConcreteProject(projectDescription: String) {
    var concreteProjectName: String?
    var templateProjectName: String?
    var sourceProjectDir: File?
    var settingsGradle: File?
    var dotTravisYml: File?
    var dotGithubDir: File?
    var codeOfConduct: File?
    var readme: File?
    var initialTemplateClassFile: File
    //
    sourceProjectDir = PathFinder.getProjectDirectory()
    templateProjectName = KOTLIN_LIBRARY_TEMPLATE_NAME
    concreteProjectName = sourceProjectDir.getName()
    // adapt settings.gradle file
    settingsGradle = File(sourceProjectDir, DependenciesInfo.SETTINGS_GRADLE_FILENAME)
    ModifyFileExtensions.modifyFile(
        settingsGradle.toPath(),
        FileChangeable { count: Int?, input: String? ->
          (input!!.replace(templateProjectName.toRegex(), concreteProjectName) +
              System.lineSeparator())
        })
    // adapt CODE_OF_CONDUCT.md file
    dotGithubDir = File(sourceProjectDir, DependenciesInfo.DOT_GITHUB_DIRECTORY_NAME)
    codeOfConduct = File(dotGithubDir, DependenciesInfo.CODE_OF_CONDUCT_FILENAME)
    ModifyFileExtensions.modifyFile(
        codeOfConduct.toPath(),
        FileChangeable { count: Int?, input: String? ->
          (input!!.replace(templateProjectName.toRegex(), concreteProjectName) +
              System.lineSeparator())
        })
    // adapt .travis.yml file
    dotTravisYml = File(sourceProjectDir, DependenciesInfo.DOT_TRAVIS_FILENAME)
    ModifyFileExtensions.modifyFile(
        dotTravisYml.toPath(),
        FileChangeable { count: Int?, input: String? ->
          (input!!.replace(templateProjectName.toRegex(), concreteProjectName) +
              System.lineSeparator())
        })
    // delete template class
    initialTemplateClassFile =
        PathFinder.getRelativePath(
            PathFinder.getSrcMainJavaDir(), "io", "github", "astrapi69", "InitialTemplate.java")

    DeleteFileExtensions.delete(initialTemplateClassFile)
    // change projectDescription from gradle.properties
    val gradleProperties = File(sourceProjectDir, DependenciesInfo.GRADLE_PROPERTIES_FILENAME)

    ModifyFileExtensions.modifyFile(
        gradleProperties.toPath(),
        FileChangeable { count: Int?, input: String? ->
          input!!.replace(
              "projectDescription=Template project for create kotlin library projects".toRegex(),
              "projectDescription=" + projectDescription) + System.lineSeparator()
        })

    // adapt README.md file
    readme = File(sourceProjectDir, DependenciesInfo.README_FILENAME)
    ModifyFileExtensions.modifyFile(
        readme.toPath(),
        FileChangeable { count: Int?, input: String? ->
          (input!!.replace(templateProjectName.toRegex(), concreteProjectName) +
              System.lineSeparator())
        })

    ModifyFileExtensions.modifyFile(
        readme.toPath(),
        FileChangeable { count: Int?, input: String? ->
          input!!.replace(
              "Template project for create kotlin library projects".toRegex(), projectDescription) +
              System.lineSeparator()
        })

    ModifyFileExtensions.modifyFile(
        readme.toPath(),
        FileChangeable { count: Int?, input: String? ->
          (input!!.replace(
              "kotlinLibraryTemplateVersion".toRegex(),
              DependenciesExtensions.getProjectVersionKeyName(concreteProjectName)) +
              System.lineSeparator())
        })

    // create run configurations for current project
    var sourceProjectDirNamePrefix: String?
    var targetProjectDirNamePrefix: String?
    var copyGradleRunConfigurationsData: CopyGradleRunConfigurations
    var sourceProjectName: String?
    var targetProjectName: String?
    sourceProjectName = templateProjectName
    targetProjectName = concreteProjectName
    sourceProjectDirNamePrefix = sourceProjectDir.getParent() + "/"
    targetProjectDirNamePrefix = sourceProjectDirNamePrefix
    copyGradleRunConfigurationsData =
        GradleRunConfigurationsCopier.newCopyGradleRunConfigurations(
            sourceProjectName,
            targetProjectName,
            sourceProjectDirNamePrefix,
            targetProjectDirNamePrefix,
            true,
            true)
    GradleRunConfigurationsCopier.of(copyGradleRunConfigurationsData).copy()

    // delete template run configurations
    RuntimeExceptionDecorator.decorate<Exception?>(
        ThrowableNoArgumentConsumer {
          DeleteFileExtensions.deleteFilesWithFileFilter(
              copyGradleRunConfigurationsData.getIdeaTargetDir(),
              PrefixFileFilter("kotlin_library_template", false))
        })
  }

  companion object {
    const val KOTLIN_LIBRARY_TEMPLATE_NAME: String = "kotlin-library-template"
  }
}
