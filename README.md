amoeba-engine
=============

Game engine for the Android platform.

How To Compile From Source
--------------------------

The android project root is `AmoebaEngine/`. All further command lines are to be run from inside this directory unless otherwise stated.

First, you must have the Android SDK saved somewhere on your local system. The current target for Amoeba Engine is: `15`.

After you have cloned the repository to your local system, you will need to tailor the build configuration to your local machine. To do this, assuming Android tools `android` is on your path, run:
	
	android update lib-project -p .

See [this page](http://developer.android.com/tools/projects/projects-cmdline.html) for more details. This process generates local machine specific configuration such that you can build Amoeba
Engine.

Now that the build system is tailor to your machine, you can compile AmoebaEngine. To do so, run:

	ant debug

Alternatively, for a release configuration, run:

	ant release

The resultant .jar file, to be referenced from your project, is located in the `deploy` directory.

To clean out any files generated as part of the build process, simply run:

	ant clean
