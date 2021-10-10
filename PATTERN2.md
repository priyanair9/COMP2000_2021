## Pattern 2

### *State* pattern

The current state of `Stage` is untidy, and two of the patterns I've implemented will go a long way to making this class much cleaner and more comprehensible. The second of these patterns is the *state* pattern.

Currently, `Stage` has a java `enum` which enumerates our various game states, we will replace each of these states with a separate class and utilise object composition. This will replace the two large switch blocks currently inside of `paint()` and `mouseClick()`.

*State* suits our requirements for Pattern 2, as it was not discussed during week 7 but is described in the textbook.
*State* is a *Behavioural* pattern.

`paint()` is greatly simplified by the use of *state* and now is very easy to comprehend, `mouseClick()` even more so as it is now fully delegated to the current concrete state.

The following are the correspending classes between the implementation here and the definitional names presented in the textbook:

  * `Stage` is our `Context` class.
  * `GameState` is our `State` interface.
  * `ChoosingActor`, `SelectingNewLocation`, `CPUMoving`, `SelectingMenuItem`, and `SelectingTarget` are our `ConcreteState` classes.
