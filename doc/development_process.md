Software Development Process
============================

This document outlines guidelines for the development process.

Best Practices
--------------

Developers should code using the latest best practices of the language being used. Please see the coding_style.md document for Best Coding Style Practices.

Documentation
-------------

Developers shall fully document all code written. Self-documenting code does not require additional comments; however, all functions and class should still have *doc-style comments. At a minimum, all interfaces must be fully *doc-style commented.

Developers must record any notes for a given issue in the relevant issue thread on github.

Overall design (from an end-user perspective) should be noted in design.md in proper markdown notation. In other words, the design document should contain all relevant information an end-user of the Amoeba Engine may need to know to use Amoeba Engine in their own projects.

Naming Conventions
------------------

Files are to be named after the class defined within, in appropriate camel case. Files should only define a single class.

Classes are to be named in appropriate camel case, with a descriptive noun indicating their purpose. All classes must belong to a package. The top-level package nomenclature is:

	com.pixelweaverstudios.amoeba

Classes may belong to a subcomponent of this package, and should be named appropriately.

Unit Testing
------------

Classes written should be fully unit tested. Developers should strive to fully unit test any code written, though coverage is at the descretion of the developer. When code is modified, unit tests should be reran, or modified, to reflect the source base. Unit tests are NOT separate issues; they are to be maintained alongside any and all production code.

Branching
---------

Using a branch for development is at the descretion of the developer. However, it is strongly recommended that branches be used when complex changes need to be made. After testing is done a local branch, the developer should then push the branch to the master repository (this is NOT equivalent to merging into the master branch). After sufficient peer review, branches can then merged into master.

Making Commits
--------------

When making commits, use the following commit message format:

	[#issueNum] - commitMessage

For example:

	[#10] - Created the developer's guide document.

The #NUM part of the commit is important; github will automagically enter a message on an issue's page link to this commit.

Peer Reviews
------------

All commits should be peer reviewed (if working on a branch, peer reviews should happen before merging into master). Code need not be peer reviewed before it has been committed, but all code must be peer reviewed before an issue may be marked as closed. Commits need only be reviewed by one other person. To notify a user to peer review your commit for a given issue, mention their name in a comment made in the issue for which you are ready to have peer reviewed. For example:

	@MrTesten - Ready for peer review, buddy!

Issue Creation
--------------

If a developer finds a bug, an issue should be created. If the bug already relates to an issue being worked in the current sprint, a comment should be made in the issue thread instead. All new issues, if not planned for the current sprint, should be added to the BackLog milestone.

All issues must be labeled accordingly, and each requires two tags: one tag to indicate type of code change, and another to indicate prioritization via MoSCoW.

The valid type tags are: enhancement, research, bug, invalid.
The priorization tags are: must have, should have, could have, won't have.

During the development process, bugs and must haves should be prioritized for completion.
