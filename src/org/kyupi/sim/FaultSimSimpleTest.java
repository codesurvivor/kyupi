/*
 * Copyright 2013 The KyuPI project contributors. See the COPYRIGHT.md file
 * at the top-level directory of this distribution.
 * This file is part of the KyuPI project. It is subject to the license terms
 * in the LICENSE.md file found in the top-level directory of this distribution.
 * No part of the KyuPI project, including this file, may be copied, modified,
 * propagated, or distributed except according to the terms contained in the
 * LICENSE.md file.
 */
package org.kyupi.sim;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.kyupi.data.FormatStil;
import org.kyupi.data.item.BVector;
import org.kyupi.data.source.QBSource;
import org.kyupi.data.source.QVSource;
import org.kyupi.faults.StuckAtCollection;
import org.kyupi.faults.StuckAtCollection.StuckAtFault;
import org.kyupi.graph.Graph;
import org.kyupi.graph.Graph.Node;
import org.kyupi.graph.GraphTools;
import org.kyupi.graph.Library;
import org.kyupi.graph.LibrarySAED;
import org.kyupi.misc.RuntimeTools;

import junit.framework.TestCase;

public class FaultSimSimpleTest extends TestCase {

	protected static Logger log = Logger.getLogger(FaultSimSimpleTest.class);

	@Test
	public void testFaultSimS27() throws Exception {
		Library l = new LibrarySAED();
		Graph g = GraphTools.loadGraph(RuntimeTools.KYUPI_HOME + "/testdata/SAED90/s27.v", l);
		//log.info("Graph=\n" + g);
		FormatStil p = new FormatStil(RuntimeTools.KYUPI_HOME + "/testdata/s27.stil", g);
		QVSource t = p.getStimuliSource();
		StuckAtCollection f = new StuckAtCollection(g);
		FaultSimSimple fsim = new FaultSimSimple(f, QBSource.from(t));
		fsim.next();
		// FIXME: assert fault detects
	}
	
	@Test
	public void testFaultSimSimple() {
		Graph g = GraphTools.benchToGraph("INPUT(a) OUTPUT(z) z=DFF(a)");
		//log.info("Graph=\n" + g);
		StuckAtCollection f = new StuckAtCollection(g);
		ArrayList<BVector> patterns = new ArrayList<BVector>();
		patterns.add(new BVector("000"));
		patterns.add(new BVector("100"));
		patterns.add(new BVector("001"));
		patterns.add(new BVector("001"));
		patterns.add(new BVector("101"));
		FaultSimSimple fsim = new FaultSimSimple(f, QBSource.from(3, patterns));
		fsim.next();
		Node a = g.searchNode("a");
		Node z = g.searchNode("z_");
		
		assertNotNull(a);
		assertNotNull(z);
		
		assertEquals(3, fsim.getDetects(StuckAtFault.newOutputSA1(a,0)));
		assertEquals(61, fsim.getDetects(StuckAtFault.newOutputSA0(a,0)));
		// FIXME: correct handling of sequential elements during fault simulation
		assertEquals(62, fsim.getDetects(StuckAtFault.newOutputSA0(z,0)));
		assertEquals(2, fsim.getDetects(StuckAtFault.newOutputSA1(z,0)));
		
		
		
	}
}
