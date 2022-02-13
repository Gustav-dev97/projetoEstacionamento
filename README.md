# projetoEstacionamento
Projeto de demonstração em JAVA desenvolvido durante o curso da IMPACTA, para administração e controle de um estacionamento:

Este software de demonstração tem como objetivo auxiliar a administração e 
controle de um estacionamento, possuindo as opções de cadastrar a entrada e saída veículos bem como o valor a ser pago,
como padrão o valor foi colocado como 0 levando em consideração a tolerância de 15 minutos em consideração, mas caso queira
poderá altera-lo como preferir. Também possui a opção de emitir relatórios com base no mês/ano com acesso restrito protegido 
por senha, PARA ACESSAR A ÁREA DE RELATÓRIO BASTA INSERIR ESTA SENHA: gu1234.

Execute os arquivos abaixo para a criação do banco de dados e
suas respectivas tabelas e colunas: 

	1-estacionamento_tb_movimentacao.sql
	2-estacionamento_tb_status_vaga.sql

ANTES de realizar o primeiro uso execute o arquivo abaixo para inicializar as vagas ocupadas como 0 e definir o horário
do seu banco de dados com o padrão brasileiro (-3:00):

	inserirNoPrimeiroUso.sql
-----------------------------------------------------------------------------------------------------------------------------

1 - Para utilizar a aplicação basta executar o atalho "GustavoDev" estará tudo pronto para ser executado e utilizado, verifique 
se possui a máquina virtual Java instalado no seu computador.

2- Caso tenha extraído o arquivo .zip, coloque o arquivo "Estacionamento-1.0-SNAPSHOT-jar-with-dependencies.jar" dentro da 
pasta "Estacionamento" e execute-o pois se o arquivo .jar estiver fora da pasta "Estacionamento" o software pode apresentar 
um comportamento diferente do desejado.

3- IMPORTANTE: Por padrão o software irá se conectar com o banco de dados MySql utilizando usuário "root" e não possui senha, 
mas caso tenha alterado seu nome de usuário e/ou senha no MySql deverá também alterá-la dentro do aquivo "configuration.txt
presente no diretório: /recursos/configuration.txt, caso ao contrário ele não irá conseguir cadastrar o veículo no banco de 
dados.

-----------------------------------------------------------------------------------------------------------------------------
Se precisar entrar em contato comigo pode encontrar pelos meios de comunicação abaixo:

	e-Mail: gustavo.dev97@gmail.com
	GitHub: github.com/Gustav-dev97

	Muito Obrigado!
