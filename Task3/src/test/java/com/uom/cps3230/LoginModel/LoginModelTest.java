package com.uom.cps3230.LoginModel;

import com.uom.cps3230.AlertLimitModel.AlertLimitModelTest;
import com.uom.cps3230.AlertLimitModel.enums.AlertLimitStates;
import com.uom.cps3230.LoginModel.enums.LoginStates;
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

public class LoginModelTest implements FsmModel {

    LoginRunner sut = new LoginRunner();

    //starting state
    LoginStates stateEnum = LoginStates.LOGGED_OUT;

    //variables
    boolean is_logged = false;

    @Override
    public LoginStates getState() {
        return stateEnum;
    }

    @Override
    public void reset(final boolean var1) {
        stateEnum = LoginStates.LOGGED_OUT;
        is_logged = false;
        if (var1) {
            sut = new LoginRunner();
        }
    }


    public boolean loginGuard() {
        return !getState().equals(LoginStates.LOGGED_IN);
    }
    public @Action void login() throws IOException {
        //update sut
        sut.login();

        //update model
        is_logged = true;
        stateEnum = LoginStates.LOGGED_IN;


        //checking
        assertEquals("Failed login",is_logged,sut.is_logged());
    }


    public boolean invalid_loginGuard() {
        return getState().equals(LoginStates.LOGGED_OUT);
    }
    public @Action void invalid_login() throws IOException {
        //update sut
        sut.invalid_login();

        //update model
        if (sut.is_logged()){
            stateEnum = LoginStates.BAD_STATE;
            is_logged=true;
        }
        else {
            stateEnum = LoginStates.LOGGED_OUT;
            is_logged = false;
        }
        //checking
        assertEquals("Failed invalid login",is_logged,sut.is_logged());
    }

    public boolean logoutGuard() {
        return getState().equals(LoginStates.LOGGED_IN);
    }
    public @Action void logout() throws IOException {
        //update sut
        sut.logout();

        //update model
        if (sut.is_logged()){
            stateEnum = LoginStates.BAD_STATE;
            is_logged =true;
        }
        else {
            stateEnum = LoginStates.LOGGED_OUT;
            is_logged = false;
        }
        //checking
        assertEquals("Fail logout",is_logged,sut.is_logged());
    }

    //Test runner
    @Test
    public void LoginModelRunner() {
        final GreedyTester tester = new GreedyTester(new LoginModelTest()); //Creates a test generator that can generate random walks. A greedy random walk gives preference to transitions that have never been taken before. Once all transitions out of a state have been taken, it behaves the same as a random walk.
        tester.setRandom(new Random()); //Allows for a random path each time the model is run.
        tester.buildGraph(); //Builds a model of our FSM to ensure that the coverage metrics are correct.
        tester.addListener(new StopOnFailureListener()); //This listener forces the test class to stop running as soon as a failure is encountered in the model.
        tester.addListener("verbose"); //This gives you printed statements of the transitions being performed along with the source and destination states.
        tester.addCoverageMetric(new TransitionPairCoverage()); //Records the transition pair coverage i.e. the number of paired transitions traversed during the execution of the test.
        tester.addCoverageMetric(new StateCoverage()); //Records the state coverage i.e. the number of states which have been visited during the execution of the test.
        tester.addCoverageMetric(new ActionCoverage()); //Records the number of @Action methods which have ben executed during the execution of the test.
        tester.generate(200); //Generates 500 transitions
        tester.printCoverage(); //Prints the coverage metrics specified above.
    }



}
