/**
 * 
 */
package com.saba.process;

import java.util.Comparator;

/**
 * @author rpuduppully
 *
 */
public class QDescendingComparator implements Comparator<State> {

	@Override
	public int compare(State o1, State o2) {
		return Double.compare(o2.getAlpha(), o1.getAlpha());
	}
}
