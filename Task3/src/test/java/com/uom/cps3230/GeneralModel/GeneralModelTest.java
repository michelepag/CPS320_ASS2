package com.uom.cps3230.GeneralModel;

import com.uom.cps3230.GeneralModel.enums.GeneralStates;
import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;
import nz.ac.waikato.modeljunit.GreedyTester;
import nz.ac.waikato.modeljunit.StopOnFailureListener;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import org.junit.Test;

import java.util.Random;
import static org.junit.Assert.assertEquals;

public class GeneralModelTest implements FsmModel{

    Runner sut = new Runner();


    GeneralStates stateEnum = GeneralStates.LOGIN;
    boolean is_logged = false;
    int event;

    @Override
    public GeneralStates getState() {
        return stateEnum;
    }

    @Override
    public void reset(final boolean var1) {
        stateEnum = GeneralStates.LOGIN;
        is_logged = false;
        if (var1) {
            sut = new Runner();
        }
    }


    public boolean log_outGuard(){
        return !getState().equals(GeneralStates.LOGOUT);
    }
    public @Action void log_out(){
        //update sut
        sut.log_out();

        //update model
        is_logged = false;
        stateEnum = GeneralStates.LOGOUT;
        event = 6;

        //checking
        assertEquals(is_logged,sut.isLoggedIn());
        assertEquals("Different event",event,sut.getCurrent_event());
    }

    public boolean log_inGuard(){
        return !getState().equals(GeneralStates.LOGIN);
    }
    public @Action void log_in(){
        //update sut
        sut.log_in();

        //update model
        is_logged = true;
        stateEnum = GeneralStates.LOGIN;
        event = 5;

        //checking
        assertEquals(is_logged,sut.isLoggedIn());
        assertEquals("Different event",event,sut.getCurrent_event());
    }

    public boolean view_alertsGuard(){
        return !getState().equals(GeneralStates.LOGOUT);
    }
    public @Action void view_alerts(){
        //update sut
        sut.view_alerts();

        //update model
        stateEnum = GeneralStates.ALERTS_VIEWED;
        event = 7;

        //checking
        assertEquals(is_logged,sut.isLoggedIn());
        assertEquals("Different event",event,sut.getCurrent_event());
    }

    public @Action void create_alert(){
        //update sut
        sut.create_alert();

        //update model
        stateEnum = GeneralStates.ALERTS_CREATED;
        event = 0;

        //checking
        assertEquals(is_logged,sut.isLoggedIn());
        assertEquals("Different event",event,sut.getCurrent_event());
    }

    public @Action void delete_alerts(){
        //update sut
        sut.delete_alerts();

        //update model
        stateEnum = GeneralStates.ALERTS_DELETED;
        event = 1;

        //checking
        assertEquals(is_logged,sut.isLoggedIn());
        assertEquals("Different event",event,sut.getCurrent_event());
    }


    //Test runner
    @Test
    public void ModelRunner() {
        final GreedyTester tester = new GreedyTester(new GeneralModelTest()); //Creates a test generator that can generate random walks. A greedy random walk gives preference to transitions that have never been taken before. Once all transitions out of a state have been taken, it behaves the same as a random walk.
        tester.setRandom(new Random()); //Allows for a random path each time the model is run.
        tester.buildGraph(); //Builds a model of our FSM to ensure that the coverage metrics are correct.
        tester.addListener(new StopOnFailureListener()); //This listener forces the test class to stop running as soon as a failure is encountered in the model.
        tester.addListener("verbose"); //This gives you printed statements of the transitions being performed along with the source and destination states.
        tester.addCoverageMetric(new TransitionPairCoverage()); //Records the transition pair coverage i.e. the number of paired transitions traversed during the execution of the test.
        tester.addCoverageMetric(new StateCoverage()); //Records the state coverage i.e. the number of states which have been visited during the execution of the test.
        tester.addCoverageMetric(new ActionCoverage()); //Records the number of @Action methods which have ben executed during the execution of the test.
        tester.generate(500); //Generates 500 transitions
        tester.printCoverage(); //Prints the coverage metrics specified above.
    }


}
