package com.jcurotto.AutomationDemo_test.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jcurotto.AutomationDemo_test.general.FUtils;
import com.jcurotto.AutomationDemo_test.general.TRELLOBaseTest;
import com.jcurotto.AutomationDemo_test.pages.*;

import dataProvider.dataProviderClass;

public class trelloTests extends TRELLOBaseTest {



	@Test(testName = "Login to Trello and create a new board", dataProvider="DataProvider", dataProviderClass = dataProviderClass.class)
	public void LoginToTRELLOandCREATEBOEARD(String pUsername, String pPassword, String pNombreTablero) {

		FUtils.log("Navigate to Trello");
		TRELLOLandingPage trellolp = super.goToTRELLOLandingPage();

		FUtils.log("Click en Iniciar Sesion");
		TRELLOLoginPageUsername trelloLogin = trellolp.clickIniciarSesion();

		FUtils.log("Type Username");
		TRELLOLoginPagePassword trellologinP = trelloLogin.typeUsername(pUsername);

		FUtils.log("Type Password");
		TRELLOHomePage trellohp = trellologinP.typePasswordAndClickOnLogin(pPassword);

		FUtils.log("Click on tableros");
		TRELLOCrearTableroPage trelloCT = trellohp.clickOnButtonTableros();

		FUtils.log("Agregar nombre al nuevo tablero");
		trelloCT.nombreTablero(pNombreTablero);

		FUtils.log("Clickear en el boton Creat Tablero");
		TRELLOTableropage trellotp = trelloCT.clickButtonCrearTablero();

		FUtils.log("Verificar que el tablero se creo");
		Assert.assertTrue(trellotp.verificarSielTableroSeCreo(pNombreTablero));

	}

	@Test
	public void hexactaTest(){
		hexactaLandingPage hlp = super.goToHEXACTALandingPage();
		hlp.clickButtonSearch();
		hexactaSearchResult hsr = hlp.typeSearch();
		Assert.assertTrue(hsr.verifyIfTitleExist());
	}

}
