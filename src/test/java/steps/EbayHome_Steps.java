package steps;

import static org.junit.Assert.fail;



import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import actions.Common_Actions;
import actions.EbayHome_Actions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EbayHome_Steps {
	Common_Actions common_actions;
	EbayHome_Actions ebayhome_actions;
	
	public EbayHome_Steps(Common_Actions common_actions, EbayHome_Actions ebayhome_actions) {
		this.common_actions = common_actions;
		this.ebayhome_actions = ebayhome_actions;
	}
	
	@Dado("Estou na Home Page do Ebay")
	public void estouNaHomePageDoEbay() {
	   common_actions.goToUrl("https://www.ebay.com/");
	}

	@Quando("Eu clico na Pesquisa Avançada")
	public void euClicoNaPesquisaAvancada() {
	    ebayhome_actions.clickAdvancedLink();
	}

	@Entao("Eu navego para a página de Pesquisa Avançada")
	public void euNavegoParaAPaginaDePesquisaAvancada() {
	    String expUrl = "https://www.ebay.com/sch/ebayadvsearch";
	    String actUrl = common_actions.getCurrentPageUrl();
	    if (!expUrl.equals(actUrl)) {
	    	fail("Página navegada '" + actUrl + "' não corresponde à esperada: '" + expUrl + "'");
	    }
	}
	
	@When("I serach for {string}")
	public void i_serach_for_iPhone_11(String str1) throws Exception {
		ebayhome_actions.searchAnItem(str1);
		ebayhome_actions.clickSearchButton();
		Thread.sleep(1000);
	}

	@Then("I validate atleast {int} search items present")
	public void i_validate_atleast_search_items_presentint (int count) {
	    int itemCountInt = ebayhome_actions.getSeatchItemsCount();
	    if(itemCountInt <= count) {
	    	fail("Less than 1000 results shown");
	    }
	}
	
	@When("I serach for {string} in {string} category")
	public void i_serach_for_in_category(String string, String string2) throws Exception {
		ebayhome_actions.searchAnItem(string);
		ebayhome_actions.selectCategoryOption(string2);
		ebayhome_actions.clickSearchButton();
		Thread.sleep(1000);
	}
	
	@When("I click on {string}")
	public void i_click_on(String string) throws Exception {
	   ebayhome_actions.clickOnLinkByText(string);
	   Thread.sleep(1000);
	}

	@Then("I validate that page navigates to {string} and title contains {string}")
	public void i_validate_that_page_navigates_to_and_title_contains(String url, String title) {
	    String actUrl = common_actions.getCurrentPageUrl();
	    String actTitle = common_actions.getCurrentPageTitle();
	    if (!actUrl.equals(url)) {
	    	fail("Page does navigate to expected url: " + url);
	    }
	    if (!actTitle.contains(title)) {
	    	fail("Title mismatch");
	    }
	}
}