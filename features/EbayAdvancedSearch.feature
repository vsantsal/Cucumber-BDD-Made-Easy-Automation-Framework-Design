# language: pt

Funcionalidade: Página de pesquisa avançada da Ebay

  @P24
  Cenario: Logo da Ebay na página de pesquisa avançada
    Dado Estou na página de pesquisa avançada
    Quando Clico na logo da Ebay
    Entao Navego para a página inicial da Ebay

  @P300 @setCookies
  Cenario: Pesquisa avançada de um item
    Dado Estou na página de pesquisa avançada
    Quando Eu faço pesquisa avançada de um item
      | keyword   | exclude     | min | max |
      | iPhone 11 | refurbished | 300 | 900 |