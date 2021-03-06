package com.proteus.parser.p416.ext;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.parser.p416.PopulateExtendedContextVisitor;
import com.proteus.parser.p416.gen.p416Parser.ErrorDeclarationContext;

public class ErrorDeclarationContextExt extends AbstractBaseExt{

	public ErrorDeclarationContextExt(ErrorDeclarationContext ctx) {
		addToContexts(ctx);
	}

	@Override
	public ParserRuleContext getContext(){
		return (ErrorDeclarationContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return new PopulateExtendedContextVisitor().visit(getPrimeParser(str).errorDeclaration());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof ErrorDeclarationContext){
				addToContexts((ErrorDeclarationContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+ErrorDeclarationContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
	
	@Override
	public void populateErrors(List<String> errors){
		ErrorDeclarationContext ctx = (ErrorDeclarationContext) getContext();
		List<String> names = new ArrayList<String>();
		ctx.identifierList().extendedContext.getNames(names);
		for(String name:names){
			if(!errors.contains(name))
				errors.add(name);
		}
	}
	
}
