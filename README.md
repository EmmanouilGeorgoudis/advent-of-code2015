# advent-of-code2015
Exploring differences in structure and design between Java and Kotlin implementations of a worker-based coordinate 
tracking problem, with focus on functional vs object-oriented programming.

# Day 1-3

I'm trying to apply my new knowledge working with Kotlin and the principles of functional programming by writing first 
in Java and then in Kotlin to explore the differences. No AI help was used in my code. I like elegance and clear 
function and variable names.

## Key Observations

- **Kotlin**: Uses local (nested) functions, allowing for more encapsulated and flow-based design. The logic feels 
- “built up from the bottom” near where it is used, by calling the inner functions from the first return at the bottom 
- of the global function.
- **Java**: Uses separate static methods on class level, giving a more traditional top-down, object-oriented structure.

## Usage

- Clone the repository
- Run the Kotlin or Java implementation
- Observe the unique visit count for the workers