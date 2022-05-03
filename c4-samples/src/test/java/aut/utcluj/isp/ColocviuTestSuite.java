/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aut.utcluj.isp;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author stefan
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        aut.utcluj.isp.ex1.ShopTest.class,
        aut.utcluj.isp.ex2.OnlineShopTest.class,
        aut.utcluj.isp.ex3.StockControllerTest.class,
        aut.utcluj.isp.ex4.UserCartTest.class,
        aut.utcluj.isp.ex4.UserTest.class
})
public class ColocviuTestSuite {

}
