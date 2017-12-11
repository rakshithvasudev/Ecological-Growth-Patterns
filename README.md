# Ecological-Growth-Patterns

Each site in the environment may or may not hold a single-cell bacteria (represented by a black dot). We observe generations of growth in the environment, and can watch individual organisms, reproduce, be born and die. The reproduction and life is governed by a set of rules.
The background (locations with no organisms) is white; organisms are black. I think it looks nice if each location is 4 by 4 pixels, but you can experiment with that. As I mentioned, the pattern changes as a new generation of organisms is born and the old
ones die. The simulation runs forever; as soon as a generation is “calculated” we draw it to the DrawingPanel and begin calculating the next generation.
At each location, an organism will be present in the new generation if either of the following is true:
1) There was an organism at the location in the last generation and two of the eight
neighboring locations also contained organisms;
2) Three of the eight neighboring locations contained organisms in the last generation.
