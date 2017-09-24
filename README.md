# Kopi Luwak

`luwak` is an experimentation with [Dropwizard], [Kotlin], and [React].

## Development Prerequisites

To compile, run, or package the project, you will need the following tools configured:

* Java SDK 8 distribution (choose one):
  * [Azul Zulu] (recommended), or
  * [OpenJDK], or
  * [Oracle JDK]
* [Gradle] build tool, either:
  * Install Gradle and add the executable in the system path (`gradle`), or
  * Use the provided Gradle wrapper executable (`gradlew`) 
* JavaScript build tools:
  * [Node.js] v8.5.x
  * [npm] v5.4.x

## Usage

* `npm i` to download and install front-end JavaScript dependencies
* `npm run dist` to compile and minify front-end JavaScript assets
* `gradle run` or `./gradlew run` to run the application from the command line
* `gradle build` or `./gradlew build` to compile a jar (to run with `java -jar <build jar> server`)

## Contributing

We follow the "[fork-and-pull]" Git workflow.

1. Fork the repo on GitHub
1. Commit changes to a branch in your fork (use `snake_case` convention):
   * For technical chores, use `chore/` prefix followed by the short description, e.g. `chore/do_this_chore`
   * For new features, use `feature/` prefix followed by the feature name, e.g. `feature/feature_name`
   * For bug fixes, use `bug/` prefix followed by the short description, e.g. `bug/fix_this_bug`
1. Ensure relevant test(s) are added: for bugs, or if existing behaviour are changed or updated
1. Rebase or merge from "upstream"
1. Submit a PR "upstream" with your changes

Please read [CONTRIBUTING] for more details.

## License

```
  Copyright (c) 2017 Herdy Handoko

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

             http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
```

`luwak` is released under the Apache 2 license. See the [LICENSE] file for further details.

[Azul Zulu]: https://www.azul.com/downloads/zulu/
[Bower]: https://bower.io
[CONTRIBUTING]: CONTRIBUTING.md
[Dropwizard]: http://www.dropwizard.io
[fork-and-pull]: https://help.github.com/articles/about-pull-requests/
[Gradle]: https://gradle.org
[Kotlin]: https://kotlinlang.org
[LICENSE]: https://github.com/hhandoko/luwak/blob/master/LICENSE.txt
[OpenJDK]: http://openjdk.java.net/install/
[Oracle JDK]: http://www.oracle.com/technetwork/java/javase/downloads/index.html
[Node.js]: https://nodejs.org
[npm]: https://www.npmjs.com
[React]: https://facebook.github.io/react/
