/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestion_hotel;

import views.HomePage;
import views.Login;
import views.SplashScreen;

/**
 *
 * @author hp
 */
public class Gestion_hotel {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SplashScreen screen = new SplashScreen();
        screen.setVisible(true);
        
        for(int i=0; i<=100;i++){
            try{
                Thread.sleep(50);
                screen.loadingValue.setValue(i);
            }catch(Exception e){
            }
        }
        screen.dispose();
        Login login = new Login();
        login.setVisible(true);
        
        /*HomePage home = new HomePage();
        home.setVisible(true);*/
        
    }
}
