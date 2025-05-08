BankSys - Sistema bancário construido em Java

Esse repositório consiste em um sistema bancário para trabalhar as principais ideias de POO, como objetos, classes, polimorfismo etc...

Classes:
Banco : Onde serão tratados os objetos com funções como creditar, debitar, transferir etc..
        Além de cadastrar as contas em um array de tamanho 100 para fins didáticos, mas poderiam ser usados estruturas dinâmicas como o Vector

CriarConta: Main do código, onde vão ser testadas as funções

ContaAbstrata: Classe abstrata de onde serão herdadas suas funções (Debitar é abstrato pois é construido diferentemente em outros tipos de conta)
  Conta: Conta corrente 
		ContaPoupanca: Possui de diferença o RenderJuros
		ContaEspecial: Possui o Bonus no creditar
	ContaImposto: Possui o debitar com um imposto

