package interfaces;

interface InterfaceRules {
	/**
	 * <code>x</code> is implicitly declared as <code><i style="font-weight: 200; color:
	 * orange">public static final</i></code>
	 * and is a class variable, not an object instance variable.
	 */
	int STATIC_VARIABLE = 0;
	
	/**
	 * Interface methods are implicity declared as <code><i style="font-weight: 200; color:
	 * orange">public abstract</i></code>.
	 */
	void ruleOne();
	
	/**
	 * Interface can have implementation if declared as <code><i style="font-weight: 200; color:
	 * orange">default</i></code>.
	 * @return
	 */
	default void ruleTwo() {
		System.out.println("Interface default implementation.");
	}
	
	/**
	 * Private functions can have implementations. They are not
	 */
	private void ruleThree() {
		System.out.println("Private implementation.");
	}
}

class TestInterfaceRules implements InterfaceRules {
	
	@Override
	public void ruleOne() {
		// impl
	}
	
	@Override
	public void ruleTwo() {
		// Interface variable is accessed via the class.
		int x = InterfaceRules.STATIC_VARIABLE;
		InterfaceRules.super.ruleTwo();
	}
}

