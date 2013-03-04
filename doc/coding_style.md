Coding Style
============

This document lays out the coding style to be followed when writing code for Amoeba Engine.

Enclosures
----------

Brackets should be on their own line. For example:

	void doSomething()
	{
		doSomethingElse();
	}

Brackets should be used whenever possible, including single-line conditionals, etc.

Indentation
-----------

Developers should strive to indent properly at all times. The standard suggested is a tab length of 4 spaces.

Vertical Alignment
------------------

Developers should NOT vertically align their code unless there is an obvious benefit. Vertical alignment hampers active refactoring. For example:

	String someString    = "text";
	String anotherString = "moretext";

Changing variables names at this point would produce unaligned code, and force more work than it is worth.

Packages
--------

When defining the package for a given class, the package line should be the first line in the file. When importing other packages, Android core packages should be placed first, followed by Amoeba Engine packages. For example:

	package com.pixelweaverstudios.amoeba.engine;

	import android.os.Bundle;
	import android.app.Activity;

	import com.pixelweaverstudios.amoeba.activity.GameActivity;
