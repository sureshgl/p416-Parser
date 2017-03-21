package com.proteus.parser.p416.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.SimpleExpressionListContext;

public class SimpleExpressionListContextExt extends AbstractBaseExt{

	public SimpleExpressionListContextExt(SimpleExpressionListContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (SimpleExpressionListContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).simpleExpressionList());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof SimpleExpressionListContext){
				addToContexts((SimpleExpressionListContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+SimpleExpressionListContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}