## Base projects

A couple of projects on GitHub was used as a base to bootstrap the solution: 

* Used [kotlin-dropwizard](https://github.com/benoj/kotlin-dropwizard) template to bootstrap the project. It offers
  sensible default libraries whilst keeping it simple. Some of the dependencies are a few minor versions behind, could
  be updated on future commit(s).
* Used the demo from [mortgage-mobx](https://github.com/paulhoughton/mortgage-mobx) for Webpack support for React. Some
  minor modifications were done to update the source and output path to match Java project
  structure, including disabling hot module reload.

## React vs Polymer

Whilst Polymer looks very promising, the learning curve looks to be too steep for beginners to grasp in a short amount
of time. Some of my considerations against Polymer:

* Support for existing JavaScript build tool seems to be very thin. There was only one (good) example found which shows
  how to integrate Polymer with Webpack (and none with Brunch).
* Existing Polymer + Webpack integration example found relies on Bower. There should not be a need to use two different
  tools to compile the code for use. 
