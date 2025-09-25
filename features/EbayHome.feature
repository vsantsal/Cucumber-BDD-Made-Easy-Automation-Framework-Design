# language: pt

Funcionalidade: Cenários da Home Page do Ebay

  @P1 @P2
  Cenario: Link de Pesquisa Avançada
    Dado Estou na Home Page da Ebay
    Quando Eu clico na Pesquisa Avançada
    Entao Eu navego para a página de Pesquisa Avançada

  @P1 @setCookies @Test
  Cenario: Contagem de itens pesquisados
    Dado Estou na Home Page da Ebay
    Quando Pesquiso por 'iPhone 11'
    Entao Valido que pelo menos 1000 itens foram encontrados

  @P24 @setCookies
  Cenario: Contagem de itens pesquisados - segundo item
    Dado Estou na Home Page da Ebay
    Quando Pesquiso por 'Toy Cars'
    Entao Valido que pelo menos 100 itens foram encontrados

  @P240 @setCookies
  Cenario:  Pesquisa item em categoria específica
    Dado Estou na Home Page da Ebay
    Quando Pesquiso por 'sopa' na categoria 'Bebê'
    Entao Valido que pelo menos 50 itens foram encontrados

  @P500
  Delineacao do Cenario: Links da página inicial
    Dado Estou na Home Page da Ebay
    Quando Eu clico em '<link>'
    Entao Eu valido que a página navega para '<url>' e seu título contém '<title>'

    Exemplos: :
      | link    | url                                                            | title       |
      | Veículos  | https://www.ebay.com/b/Auto-Parts-Accessories/6028/bn_569479 | Peças e acessórios automotivos |
      | Moda | https://www.ebay.com/b/Fashion/bn_7000259856                   | Moda     |
      | Esportes    | https://www.ebay.com/b/Sporting-Goods/888/bn_1865031             | Artigos esportivos        |
