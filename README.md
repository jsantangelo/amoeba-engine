amoeba-engine
=============

Amoeba Engine is a game engine for the Android platform, designed to be lightweight and modular. As a distibutable jar, Amoeba Engine should be easy to pick up and use.

How To Use
----------

Amoeba Engine is distributed as a jar, and can therefore be included/referenced by your project as a library. The overall design of Amoeba Engine, including the interfaces that can be implemented with your own custom implementation, and other documentation necessary to build your game around Amoeba Engine can be found in doc/design.md.

How To Compile From Source
--------------------------

The android project root is `AmoebaEngine/`. All further command lines are to be run from inside this directory unless otherwise stated.

First, you must have the Android SDK saved somewhere on your local system. The current target for Amoeba Engine is: `15`.

After you have cloned the repository to your local system, you will need to tailor the build configuration to your local machine. To do this, assuming Android tools `android` is on your path, run:
	
	android update lib-project -p .

See [this page](http://developer.android.com/tools/projects/projects-cmdline.html) for more details. This process generates local machine specific configuration such that you can build Amoeba
Engine.

Now that the build system is tailored to your machine, you can compile AmoebaEngine. To do so, run:

	ant debug

Alternatively, for a release configuration, run:

	ant release

The resultant `.jar` file, to be referenced from your project, is located in the `deploy` directory.

To clean out any files generated as part of the build process, simply run:

	ant clean

Using Eclipse
-------------

The project can be imported into Eclipse in the same way as any other java project.  After the repository is cloned to your system, open Eclipse and select File > Import.  You can choose General > Existing Projects into Workspace, Android > Existing Android Code into Workspace, or Git > Projects from Git (if you have a git plugin installed).

Navigate to and select the folder of the repository on you system and Eclipse should recognize the AmoebaEngine project.  Select the AmoebaEngine project and be sure NOT to copy the project into the workspace.

To view the packages in the library in an easier to read format go to Package Explorer (Ctrl+F10) > Package Presentation > Hierarchical.
