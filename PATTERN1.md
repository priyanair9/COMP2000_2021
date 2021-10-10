## Pattern 1

### *Composite* pattern

The current state of `Stage` is untidy, and two of the patterns I've implemented will go a long way to making this class much cleaner and more comprehensible. The first of these patterns is the *composite* pattern.

Originally I had planned to utilise the *decorator* pattern, or perhaps even the *observer* pattern however after seeing a couple of students use *composite* in an interesting and efficient way I decided that it would be good to replicate it here.

It suits our requirements for Pattern 1, as it was discussed during week 7.
*Composite* is a *Strutural* pattern.

The side-panel where statistics of the game are currently presented is ad-hoc and full of various code smells such as magic numbers.

By utilising the composite pattern to represent a series of nested, and yet separate display areas the code is nicely compartmentalised.

`Stage` simply calls upon `SidePanel` which recursively calls upon it's leaves which then display the relevant information.

The following are the correspending classes between the implementation here and the definitional names presented in the textbook:

  * `Stage` is our `Client` class.
  * `InfoPanel` is our `Component` class.
  * `SidePanel` is our `Composite` class.
  * `ActorInfo`, and `StageInfo` are our `Leaf` classes.
