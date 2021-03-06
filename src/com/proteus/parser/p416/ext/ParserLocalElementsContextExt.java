package com.proteus.parser.p416.ext;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.ParserLocalElementsContext;

public class ParserLocalElementsContextExt extends AbstractBaseExt{

	public ParserLocalElementsContextExt(ParserLocalElementsContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (ParserLocalElementsContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).parserLocalElements());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof ParserLocalElementsContext){
				addToContexts((ParserLocalElementsContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+ParserLocalElementsContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}
