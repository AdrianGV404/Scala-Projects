package main.java.interfaces;

import main.java.Action;
import main.java.Invoker;
import java.util.ArrayList;

/**
 * Interface representing a distribution policy for actions among invokers.
 * This follows the Strategy pattern.
 */
public interface DistributionPolicy {

    /**
     * Distributes a list of actions among a list of invokers based on the specific policy.
     *
     * @param actions  The list of actions to be distributed.
     * @param invokers The list of invokers to which actions are to be distributed.
     * @return {@code true} if the distribution is successful, {@code false} otherwise.
     */
    boolean distributeActions(ArrayList<Action> actions, ArrayList<Invoker> invokers);
}
