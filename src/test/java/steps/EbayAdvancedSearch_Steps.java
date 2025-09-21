package steps;

import static org.junit.Assert.fail;

import actions.Common_Actions;
import actions.EbayAdvancedSearch_Actions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;


public class EbayAdvancedSearch_Steps {
	Common_Actions common_actions;
	EbayAdvancedSearch_Actions ebayadvancedsearch_actions;
	
	public EbayAdvancedSearch_Steps(Common_Actions common_actions, EbayAdvancedSearch_Actions ebayadvancedsearch_actions) {
		this.common_actions = common_actions;
		this.ebayadvancedsearch_actions = ebayadvancedsearch_actions;
	}
	
	@Dado("Estou na página de pesquisa avançada")
	public void estouNaPaginaDePesquisaAvancada() throws InterruptedException {
		common_actions.goToUrl("https://www.ebay.com/sch/ebayadvsearch");
	}

	@Quando("Clico na logo da Ebay")
	public void clicoNaLogoDaEbay() {
		ebayadvancedsearch_actions.clickOnEbayLogo();
	}

	@Entao("Navego para a página inicial da Ebay")
	public void navegoParaInicialDaEbay() {
	    String expUrl = "https://www.ebay.com/";
	    String actUrl = common_actions.getCurrentPageUrl();
	    if (!expUrl.equals(actUrl)) {
	    	fail("Página navegada '" + actUrl + "' não corresponde à esperada: '" + expUrl + "'");
	    }
	}
	
	@Quando("I advanced search an item")
	public void i_advanced_search_an_item(DataTable dataTable) throws Exception {
		ebayadvancedsearch_actions.enterSearchString(dataTable.cell(1, 0));
		ebayadvancedsearch_actions.enterExcludeString(dataTable.cell(1, 1));
		ebayadvancedsearch_actions.enterMinPrice(dataTable.cell(1, 2));
		ebayadvancedsearch_actions.enterMaxPrice(dataTable.cell(1, 3));
		ebayadvancedsearch_actions.clickOnSearchBtn();
	}
}
