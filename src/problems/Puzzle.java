/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems;

import search.models.Problem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danieljunior
 */
public class Puzzle extends Problem<int[][], PuzzleAction> {

    public Puzzle(List<PuzzleAction> actions, int[][] initialState, int[][] solution) {
        super(actions, initialState, solution);
    }

    @Override
    public boolean isFinal(int[][] state) {
        for (int i = 0; i < getSolution().length; i++) {
            for (int j = 0; j < getSolution()[i].length; j++) {
                if (getSolution()[i][j] != state[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public List<PuzzleAction> actions(int[][] state) {
        ArrayList<PuzzleAction> resp = new ArrayList<>();
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                if (state[i][j] == 0) {
                    if (i + 1 < state.length) {
                        resp.add(PuzzleAction.DOWN);
                    }
                    if (i - 1 >= 0) {
                        resp.add(PuzzleAction.UP);
                    }
                    if (j + 1 < state[i].length) {
                        resp.add(PuzzleAction.RIGHT);
                    }
                    if (j - 1 >= 0) {
                        resp.add(PuzzleAction.LEFT);
                    }
                }
            }
        }

        return resp;
    }

    @Override
    public int[][] result(int[][] state, PuzzleAction action) {
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                if (state[i][j] == 0) {
                    int temp;
                    switch (action) {
                        case DOWN:
                            temp = state[i + 1][j];
                            state[i + 1][j] = 0;
                            state[i][j] = temp;
                            break;
                        case UP:
                            temp = state[i - 1][j];
                            state[i - 1][j] = 0;
                            state[i][j] = temp;
                            break;
                        case RIGHT:
                            temp = state[i][j + 1];
                            state[i][j + 1] = 0;
                            state[i][j] = temp;
                            break;
                        case LEFT:
                            temp = state[i][j - 1];
                            state[i][j - 1] = 0;
                            state[i][j] = temp;
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return state;
    }

    @Override
    public int stepCost(int[][] state, PuzzleAction action) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
