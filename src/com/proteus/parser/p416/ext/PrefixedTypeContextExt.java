package com.proteus.parser.p416.ext;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.PrefixedTypeContext;

public class PrefixedTypeContextExt extends AbstractBaseExt{

	public PrefixedTypeContextExt(PrefixedTypeContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (PrefixedTypeContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).prefixedType());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof PrefixedTypeContext){
				addToContexts((PrefixedTypeContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+PrefixedTypeContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
	
	@Override
	protected String getPrefixedType(){
		return getContext().getText();
	}
}
