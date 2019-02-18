package com.sixt.qa.ui.testCleartrip.testClearTrip.Pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.springframework.stereotype.Component;

@Component
public class ClearTripPage extends PageObject {
    @FindBy(id = "OneWay")
    private WebElementFacade oneWay;

    @FindBy(id = "FromTag")
    private WebElementFacade fromTag;

    @FindBy(id = "ToTag")
    private WebElementFacade toTag;

    @FindBy(id = "SearchBtn")
    private WebElementFacade searchBtnFlight;

    @FindBy(linkText = "hotels")
    private WebElementFacade hotelLink;

    @FindBy(id = "Tags")
    private WebElementFacade tagSearch;

    @FindBy(id = "CheckInDate")
    private WebElementFacade checkInDate;

    @FindBy(id = "CheckOutDate")
    private WebElementFacade checkOutDate;

    @FindBy(id = "CheckInDate")
    private WebElementFacade CheckInDate;

    @FindBy(id = "travellersOnhome")
    private WebElementFacade travellersOnhome;

    @FindBy(id = "SearchHotelsButton")
    private WebElementFacade searchHotelsButton;


}
