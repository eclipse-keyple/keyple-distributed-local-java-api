# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [2.2.0] - 2024-09-06
### Added
- Added a new method `boolean isReaderContactless(String readerName)` to the `LocalServiceApi` interface.
  This method enables the Local lib to identify whether or not a reader is contactless, 
  so that it can transmit this information to the Remote lib as soon as possible. 
  This reduces the number of network exchanges.

## [2.1.1] - 2024-04-12
### Changed
- Java source and target levels `1.6` -> `1.8`
### Upgraded
- Gradle `6.8.3` -> `7.6.4`

## [2.1.0] - 2023-11-27
### Added
- Added a new method `int exchangeApiLevel(int coreApiLevel)` to the `LocalServiceSpi` interface to enable Core and
  Distributed layers to exchange their JSON API levels.
- `CHANGELOG.md` file (issue [eclipse-keyple/keyple#6]).
- Added project status badges on `README.md` file.
- CI: Forbid the publication of a version already released (issue [#3]).
### Fixed
- CI: code coverage report when releasing.

## [2.0.0] - 2021-10-06
This is the initial release.
It follows the extraction of Keyple 1.0 components contained in the `eclipse-keyple/keyple-java` repository to dedicated repositories.
It also brings many major API changes.

[unreleased]: https://github.com/eclipse-keyple/keyple-distributed-local-java-api/compare/2.2.0...HEAD
[2.2.0]: https://github.com/eclipse-keyple/keyple-distributed-local-java-api/compare/2.1.1...2.2.0
[2.1.1]: https://github.com/eclipse-keyple/keyple-distributed-local-java-api/compare/2.1.0...2.1.1
[2.1.0]: https://github.com/eclipse-keyple/keyple-distributed-local-java-api/compare/2.0.0...2.1.0
[2.0.0]: https://github.com/eclipse-keyple/keyple-distributed-local-java-api/releases/tag/2.0.0

[#3]: https://github.com/eclipse-keyple/keyple-distributed-local-java-api/issues/3

[eclipse-keyple/keyple#6]: https://github.com/eclipse-keyple/keyple/issues/6