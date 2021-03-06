/*
 * Copyright 2013 The KyuPI project contributors. See the COPYRIGHT.md file
 * at the top-level directory of this distribution.
 * This file is part of the KyuPI project. It is subject to the license terms
 * in the LICENSE.md file found in the top-level directory of this distribution.
 * No part of the KyuPI project, including this file, may be copied, modified,
 * propagated, or distributed except according to the terms contained in the
 * LICENSE.md file.
 */
package org.kyupi.graph;

import java.io.OutputStream;
import java.io.PrintWriter;

import org.apache.log4j.Logger;
import org.kyupi.graph.Graph.Node;

public class FormatKyupi {

	protected static Logger log = Logger.getLogger(FormatKyupi.class);

	public static void save(OutputStream os, Graph graph, String name) {
		PrintWriter op = new PrintWriter(os);
		op.println("# Kyupi Graph Dump 1");
		op.println("# Name " + name);
		Node[] nodes = graph.accessNodes();
		for (Node node : nodes) {
			if (node == null) {
				continue;
			}
			String s = "Node";
			if (node.isPrimary()) {
				s += " primary";
			}
			if (node.isInput()) {
				s += " input";				
			}
			if (node.isOutput()) {
				s += " output";				
			}
			if (node.isPseudo()) {
				s += " pseudo";				
			}
			s += " " + node.queryName() + " (";
			for (int i = 0; i <= node.maxIn(); i++) {
				if (node.in(i) != null) {
					s += " " + node.inName(i) + ": " + node.in(i).queryName();
				}
			}
			s += " ) " + node.typeName() + " (";
			for (int i = 0; i <= node.maxOut(); i++) {
				if (node.out(i) != null) {
					s += " " + node.outName(i) + ": " + node.out(i).queryName();
				}
			}
			s += " )";
			op.println(s);
		}
		op.close();
	}
}
