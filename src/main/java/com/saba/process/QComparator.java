/**
 * 
 */
package com.saba.process;

import java.util.Comparator;

/**
 * @author rpuduppully
 *
 */
public class QComparator implements Comparator<State> {

	@Override
	public int compare(State o1, State o2) {
		return Double.compare(o1.getAlpha(), o2.getAlpha());
	}
}
