package Config;

public class OR {

	// AUTO-TRADER
	public static final String carMake = "//*[@id='j_id_1_e9-j_id_1_ea_1-j_id_1_ea_5-j_id_1_ea_8-j_id_1_ea_f-homepageMake-selectOneMenu']";
	public static final String carModel = "//*[@id='j_id_1_e9-j_id_1_ea_1-j_id_1_ea_5-j_id_1_ea_8-j_id_1_ea_f-homepageModel-selectOneMenu']";
	public static final String price = "//*[@id='j_id_1_e9-j_id_1_ea_1-j_id_1_ea_5-j_id_1_ea_8-j_id_1_ea_f-homepagePrice-selectOneMenu']";
	public static final String zipCodeAT = "//*[@id='j_id_1_e9-j_id_1_ea_1-j_id_1_ea_5-j_id_1_ea_8-j_id_1_ea_f-j_id_1_ea_1e']";
	public static final String searchBtn = "//*[@id='j_id_1_e9-j_id_1_ea_1']/div/div[1]/div/div[1]/a";
	public static final String advanceSearch = "//*[@id='j_id_1_dw-j_id_1_dx_1']/div/div[1]/div/div[2]/a";
											

	//A2_SearchPage
	public static final String radiusRange = "//*[@id='searchform-col-wrapper-col1-listingsSearch-search-area-fr-searchRange-selectOneMenu']";
	public static final String zippCode = "//*[@id='searchform-col-wrapper-col1-listingsSearch-search-area-fr-zipCode']";
	public static final String newCheckBox = "//*[@id='searchform-col-wrapper-col1-listingsSearch-search-type-listingType']/li[1]/label";
	public static final String usedCheckBox = "//*[@id='searchform-col-wrapper-col1-listingsSearch-search-type-listingType']/li[2]/label";
	public static final String certifiedCheckBox = "//*[@id='searchform-col-wrapper-col1-listingsSearch-search-type-listingType']/li[3]/label";
	public static final String minPrice = "//*[@id='searchform-col-wrapper-col1-listingsSearch-prices-col1-fr-minPrice-selectOneMenu']";
	public static final String maxPrice = "//*[@id='searchform-col-wrapper-col1-listingsSearch-prices-col2-fr-maxPrice-selectOneMenu']";
	public static final String allStyles = "//*[@id='allStylesSelector']";
	public static final String fromYear = "//*[@id='searchform-col-wrapper-col1-listingsSearch-years-col1-fr1-fromYear-selectOneMenu']";
	public static final String toYear = "//*[@id='searchform-col-wrapper-col1-listingsSearch-years-col3-fr2-toYear-selectOneMenu']";
	public static final String carSearch = "//*[@id='searchform-col-wrapper-col1-listingsSearch-j_id_1_mx-j_id_1_mz-j_id_1_mz']";
	public static final String modelAWD = "//*[@id='searchform-col-wrapper-col1-listingsSearch-bodystyle-j_id_1_g3-vehicleStyleCodes']/li[1]";
	public static final String modelCom = "//*[@id='searchform-col-wrapper-col1-listingsSearch-bodystyle-j_id_1_g3-vehicleStyleCodes']/li[2]";
	public static final String modelStyle = "//*[@id='searchform-col-wrapper-col1-listingsSearch-bodystyle-j_id_1_g3-vehicleStyleCodes']/li[";
	public static final String modelStyelNum = "]/label";
	
	//A3_ResultPage
	public static final String adImage = "//*[@id='aw0']/img";
	public static final String searchResultText = "//*[@id='subtitleForm']/div[1]/span[1]";
	public static final String yourSearchHeading = "//*[@id='j_id_fe-j_id_fo-searchSummary']/div/div[1]";
	public static final String sortBy = "//*[@id='searchRangeContainer']/label[1]";
	public static final String priceDropDown = "//*[@id='j_id_1q2-listingControls-searchRangeContainer-sortBy-selectOneMenu']";
	public static final String perPage = "//*[@id='searchRangeContainer']/label[2]";
	public static final String numItemsperPage = "//*[@id='j_id_1q2-listingControls-searchRangeContainer-numRecords-selectOneMenu']";
	public static final String listBtn = "/*[@id='j_id_1q2-listingControls-searchRangeContainer-listView']";
	public static final String GridBtn = "//*[@id='j_id_1q2-listingControls-searchRangeContainer-galleryView']";
	public static final String pageWhtofWhat = "//*[@id='j_id_1q2-listingsPagination']/span[2]";
	public static final String pageArrowNext = "//*[@id='j_id_1q2-listingsPagination-j_id_1rm']";
	
	
	
	// WELLS-FARGO HOME PAGE
	public static final String Insurance = "//*[@id='insuranceTab']/a";
	public static final String Banking = "//*[@id='bankingTab']/a";
	public static final String getQuotes = "//*[@id='insurance']/div[3]/ul/li[1]/a";
	public static final String MortgageRate = "//*[@id='banking']/div[3]/ul/li[1]/a";
	
	// A2_clickGetQuotesBtns
	public static final String getAutoQuote = "//*[@id='NID1_5_1_1_2_1_2_1']";
	public static final String getRentQuote = "//*[@id='//*[@id='NID1_5_1_1_2_2_2_1']";
	public static final String getHomeQuote = "//*[@id='//*[@id='NID1_5_1_1_4_1_2_1']";
	public static final String getLifeQuote = "//*[@id='//*[@id='NID1_5_1_1_4_2_2_1']";
	
	// A3_getQuoteStep1
	public static final String selectQuote = "//*[@id='Applicant_LOB']";
	public static final String zipCode = "//*[@id='Rating_Zip']";
	public static final String radioNo = "//*[@id='Custom_HavePriorAutoInsurance_No']";
	public static final String radioYes = "//*[@id='Custom_HavePriorAutoInsurance_Yes']";
	public static final String continueBtn = "//*[@id='cpForm']/table/tbody/tr[12]/td/div[2]/div/div/input";
	
	//A4_getQuoteStep2
	public static final String firstName = "//*[@id='Driver1_FirstName']";
	public static final String lastName = "//*[@id='Driver1_LastName']";
	public static final String Address = "//*[@id='Applicant1_AddressLine1']";
	public static final String city = "//*[@id='Applicant1_City']";
	public static final String zip = "//*[@id='Rating1_Zip']";
	
	//A5_MortgageRateMain
	public static final String PurchaseRate = "//*[@id='tab-purchaserates']/p";
	public static final String Box = "//*[@id='contentBody']/div/div";
	public static final String tData = "//*[@id='PurchaseRatesTable']/tbody/tr[";
	public static final String trNum = "]/td[";
	public static final String tcNum = "]";
	
	
	
}
