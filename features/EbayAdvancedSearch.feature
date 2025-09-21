# language: pt

Funcionalidade: Página de pesquisa avançada da Ebay

  @P24
  Cenario: Logo da Ebay na página de pesquisa avançada
    Dado Estou na página de pesquisa avançada
    Quando Clico na logo da Ebay
    Entao Navego para a página inicial da Ebay

#	@P300 @setCookies
#  Scenario: Advanced search an item
#    Given I am Ebay Advanced Search Page
#    When I advanced search an item
#      | keyword   | exclude     | min | max |
#      | iPhone 11 | refurbished | 300 | 900 |