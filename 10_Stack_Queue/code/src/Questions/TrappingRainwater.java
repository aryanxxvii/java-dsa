package Questions;

public class TrappingRainwater {

    // ARRAY =>     3 0 0 2 0 4
    // Max Left =>  3 3 3 3 3 4
    // Max Right => 4 4 4 4 4 4
    // Min =>       3 3 3 3 3 4
    // Heights =>   3 0 0 2 0 4
    // Min - H =>   0 3 3 1 3 0 => Sum = 10 = ANSWER

    // We find the water trapped in each height separately
    // Find bounds for each height, then find area trapped in that height
    // Sum all trapped water for answer

}
