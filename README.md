# Overview

<div style="text-align: center">

[![Build Status](https://travis-ci.com/astrapi69/kotlin-library-template.svg?branch=master)](https://travis-ci.com/astrapi69/kotlin-library-template)
[![Coverage Status](https://codecov.io/gh/astrapi69/kotlin-library-template/branch/develop/graph/badge.svg)](https://codecov.io/gh/astrapi69/kotlin-library-template)
[![Open Issues](https://img.shields.io/github/issues/astrapi69/kotlin-library-template.svg?style=flat)](https://github.com/astrapi69/kotlin-library-template/issues)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/kotlin-library-template/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/kotlin-library-template)
[![Javadocs](http://www.javadoc.io/badge/io.github.astrapi69/kotlin-library-template.svg)](http://www.javadoc.io/doc/io.github.astrapi69/kotlin-library-template)
[![MIT license](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Donate](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)

</div>

Template project for create kotlin library projects.

If you like this project put a ⭐ and donate

# Template from this project

You can derive your kotlin library project from this you can easily and adapt to your specific project if you follow the
instruction from this [medium blog](https://asterios-raptis.medium.com/new-github-template-repository-feature-ec09afe261b8)

## Note

No animals were harmed in the making of this library.

# Donations

If you like this library, please consider a donation through paypal: <a href="https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=B37J9DZF6G9ZC" target="_blank">
<img src="https://www.paypalobjects.com/en_US/GB/i/btn/btn_donateCC_LG.gif" alt="PayPal this" title="PayPal – The safer, easier way to pay online!" border="0" />
</a>

or over bitcoin or bitcoin-cash with:

36JxRRDfRazLNqUV6NsywCw1q7TK38ukpC

or over ether with:

0x588Aa02De98B1Ef70afeDC3ec5290130a3E5e273

or over flattr:
<a href="https://flattr.com/submit/auto?user_id=astrapi69&url=https://github.com/astrapi69/kotlin-library-template" target="_blank">
<img src="http://api.flattr.com/button/flattr-badge-large.png" alt="Flattr this" title="Flattr this" border="0" />
</a>

## License

The source code comes under the liberal MIT License, making kotlin-library-template great for all types of applications.

## Maven dependency

Maven dependency is now on sonatype.
Check out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;gav~io.github.astrapi69~kotlin-library-template~~~) for latest snapshots and releases.

Add the following maven dependency to your project `pom.xml` if you want to import the core
functionality of kotlin-library-template:

Than you can add the dependency to your dependencies:

    <properties>
            ...
        <!-- kotlin-library-template version -->
        <kotlin-library-template.version>1</kotlin-library-template.version>
            ...
    </properties>
            ...
        <dependencies>
            ...
            <!-- kotlin-library-template DEPENDENCY -->
            <dependency>
                <groupId>io.github.astrapi69</groupId>
                <artifactId>kotlin-library-template</artifactId>
                <version>${kotlin-library-template.version}</version>
            </dependency>
            ...
        </dependencies>

## gradle dependency

You can first define the version in the ext section and add than the following gradle dependency to
your project `build.gradle` if you want to import the core functionality of kotlin-library-template:

define version in file gradle.properties
```
kotlinLibraryTemplateVersion=1
```

or in build.gradle ext area

```
ext {
            ...
    kotlinLibraryTemplateVersion = "1"
            ...
}
```

and than add the dependency to the dependencies area

```
dependencies {
            ...
    implementation("io.github.astrapi69:kotlin-library-template:kotlinLibraryTemplateVersion")
            ...
}
```

## Semantic Versioning

The versions of kotlin-library-template are maintained with the Semantic Versioning guidelines.

Release version numbers will be incremented in the following format:

`<major>.<minor>.<patch>`

For detailed information on versioning you can visit the [wiki page](https://github.com/lightblueseas/mvn-parent-projects/wiki/Semantic-Versioning).

## Want to Help and improve it? ###

The source code for kotlin-library-template are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [astrapi69/kotlin-library-template/fork](https://github.com/astrapi69/kotlin-library-template/fork)

To share your changes, [submit a pull request](https://github.com/astrapi69/kotlin-library-template/pull/new/develop).

Don't forget to add new units tests on your changes.

## Contacting the Developers

Do not hesitate to contact the kotlin-library-template developers with your questions, concerns, comments, bug reports, or feature requests.
- Feature requests, questions and bug reports can be reported at the [issues page](https://github.com/astrapi69/kotlin-library-template/issues).

## Similar projects

## Credits
