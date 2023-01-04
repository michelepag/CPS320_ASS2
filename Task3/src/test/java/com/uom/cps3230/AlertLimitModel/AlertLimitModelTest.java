package com.uom.cps3230.AlertLimitModel;

import com.uom.cps3230.AlertLimit.AlertLimitRunner;
import com.uom.cps3230.AlertLimitModel.enums.AlertLimitStates;
import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;
import nz.ac.waikato.modeljunit.GreedyTester;
import nz.ac.waikato.modeljunit.StopOnFailureListener;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import org.junit.Test;

import java.io.IOException;
import java.util.Random;
import static org.junit.Assert.assertEquals;
public class AlertLimitModelTest implements FsmModel {
    AlertLimitRunner sut = new AlertLimitRunner();

    //starting state
    AlertLimitStates stateEnum = AlertLimitStates.START;

    //variables
    boolean is_over_limit = false;
    boolean is_zero = true;

    int n_alert=0;

    @Override
    public AlertLimitStates getState() {
        return stateEnum;
    }

    @Override
    public void reset(final boolean var1) {
        stateEnum = AlertLimitStates.START;
        is_over_limit = false;
        is_zero = true;
        n_alert=0;
        if (var1) {
            sut = new AlertLimitRunner();
        }
    }

    public @Action void create_alert() throws IOException {
        //update sut
        sut.create_alert();

        //update model
        n_alert++;
        is_zero=false;
        if(n_alert > 5){
            is_over_limit = true;
            stateEnum = AlertLimitStates.TOO_MANY;
        }
        else {
            stateEnum = AlertLimitStates.START;
        }

        //checking
        assertEquals("Different number of alerts",n_alert,sut.getN_alerts());
        assertEquals("Different event",is_over_limit,sut.is_over_limit());
    }

    public boolean delete_alertsGuard() {
        return getState().equals(AlertLimitStates.START) || getState().equals(AlertLimitStates.TOO_MANY);
    }
    public @Action void delete_alerts() throws IOException {
        //update sut
        sut.delete_alerts();

        //update model
        n_alert=0;

        if(n_alert > 0){
            is_over_limit = true;
            stateEnum = AlertLimitStates.BAD_DELETE;
        } else if (n_alert > 5) {
            is_over_limit = true;
        } else {
            stateEnum = AlertLimitStates.START;
            is_zero=true;
            is_over_limit = false;
        }

        //checking
        assertEquals("Different number of alerts",n_alert,sut.getN_alerts());
        assertEquals("Different event",is_over_limit,sut.is_over_limit());
        assertEquals("Different event",is_zero,sut.is_zero());
    }

    //Test runner
    @Test
    public void AlertLimitModelRunner() {
        final GreedyTester tester = new GreedyTester(new AlertLimitModelTest()); //Creates a test generator that can generate random walks. A greedy random walk gives preference to transitions that have never been taken before. Once all transitions out of a state have been taken, it behaves the same as a random walk.
        tester.setRandom(new Random()); //Allows for a random path each time the model is run.
        tester.buildGraph(); //Builds a model of our FSM to ensure that the coverage metrics are correct.
        tester.addListener(new StopOnFailureListener()); //This listener forces the test class to stop running as soon as a failure is encountered in the model.
        tester.addListener("verbose"); //This gives you printed statements of the transitions being performed along with the source and destination states.
        tester.addCoverageMetric(new TransitionPairCoverage()); //Records the transition pair coverage i.e. the number of paired transitions traversed during the execution of the test.
        tester.addCoverageMetric(new StateCoverage()); //Records the state coverage i.e. the number of states which have been visited during the execution of the test.
        tester.addCoverageMetric(new ActionCoverage()); //Records the number of @Action methods which have ben executed during the execution of the test.
        tester.generate(150); //Generates 150 transitions
        tester.printCoverage(); //Prints the coverage metrics specified above.
    }

}
