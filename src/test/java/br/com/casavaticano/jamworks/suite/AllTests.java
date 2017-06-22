package br.com.casavaticano.jamworks.suite;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.casavaticano.jamworks.Teste;


/**

 * Classe que agrupa todas as classes de teste, funcionando com uma su�te de regress�o.

 * @author jcan

 *

 */

@RunWith(Suite.class)

@Suite.SuiteClasses({ 

	Teste.class

	})


public class AllTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}


}
