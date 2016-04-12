/*
 * Copyright (C) 2015 The JavaParser Team.
 *
 * This file is part of JavaParser.
 * 
 * JavaParser can be used either under the terms of
 * a) the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * b) the terms of the Apache License 
 *
 * You should have received a copy of both licenses in LICENCE.LGPL and
 * LICENCE.APACHE. Please refer to those files for details.
 *
 * JavaParser is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 */

package com.github.javaparser;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.Statement;

/**
 * @author Sebastian Kuerten
 */
public class InstanceJavaParser
{

    private ASTParser astParser;

    public InstanceJavaParser(InputStream input)
    {
        astParser = new ASTParser(input);
    }

    public InstanceJavaParser(InputStream input, String encoding)
    {
        astParser = new ASTParser(input, encoding);
    }

    public InstanceJavaParser(File file) throws FileNotFoundException
    {
        InputStream input = new BufferedInputStream(new FileInputStream(file));
        astParser = new ASTParser(input);
    }

    public InstanceJavaParser(File file, String encoding)
            throws FileNotFoundException
    {
        InputStream input = new BufferedInputStream(new FileInputStream(file));
        astParser = new ASTParser(input, encoding);
    }

    public InstanceJavaParser(Reader reader)
    {
        astParser = new ASTParser(reader);
    }

    /**
     * Return the list of tokens that have been encountered while parsing code
     * using this parser.
     *
     * @return a list of tokens
     */
    public List<Token> getTokens() {
        return astParser.getTokens();
    }

    /**
     * Parses the Java code and returns a {@link CompilationUnit} that
     * represents it.
     *
     * @return CompilationUnit representing the Java source code
     * @throws ParseException
     *             if the source code has parser errors
     */
    public CompilationUnit parse() throws ParseException {
        return astParser.CompilationUnit();
    }

    /**
     * Parses the Java block and returns a {@link BlockStmt} that represents it.
     *
     * @return BlockStmt representing the Java block
     * @throws ParseException
     *             if the source code has parser errors
     */
    public BlockStmt parseBlock() throws ParseException {
        return astParser.Block();
    }

    /**
     * Parses the Java block and returns a {@link List} of {@link Statement}s
     * that represents it.
     *
     * @return Statement representing the Java statement
     * @throws ParseException
     *             if the source code has parser errors
     */
    public List<?> parseStatements() throws ParseException {
        return astParser.Statements();
    }

    /**
     * Parses the Java statement and returns a {@link Statement} that represents
     * it.
     *
     * @return Statement representing the Java statement
     * @throws ParseException
     *             if the source code has parser errors
     */
    public Statement parseStatement() throws ParseException {
        return astParser.Statement();
    }

    /**
     * Parses the Java import and returns a {@link ImportDeclaration} that
     * represents it.
     *
     * @return ImportDeclaration representing the Java import declaration
     * @throws ParseException
     *             if the source code has parser errors
     */
    public ImportDeclaration parseImport() throws ParseException {
        return astParser.ImportDeclaration();
    }

    /**
     * Parses the Java expression and returns a {@link Expression} that
     * represents it.
     *
     * @return Expression representing the Java expression
     * @throws ParseException
     *             if the source code has parser errors
     */
    public Expression parseExpression() throws ParseException {
        return astParser.Expression();
    }

    /**
     * Parses the Java annotation and returns a {@link AnnotationExpr} that
     * represents it.
     *
     * @return AnnotationExpr representing the Java annotation
     * @throws ParseException
     *             if the source code has parser errors
     */
    public AnnotationExpr parseAnnotation() throws ParseException {
        return astParser.Annotation();
    }

    /**
     * Parses the Java body declaration(e.g fields or methods) and returns a
     * {@link BodyDeclaration} that represents it.
     *
     * @return BodyDeclaration representing the Java body
     * @throws ParseException
     *             if the source code has parser errors
     */
    public BodyDeclaration parseBodyDeclaration() throws ParseException {
        return astParser.AnnotationBodyDeclaration();
    }

    /**
     * Parses the Java body declaration(e.g fields or methods) and returns a
     * {@link BodyDeclaration} that represents it.
     *
     * @param isInterface
     *            whether the parsed source code is an interface.
     *
     * @return BodyDeclaration representing the Java body
     * @throws ParseException
     *             if the source code has parser errors
     */
    public BodyDeclaration parseClassOrInterfaceBodyDeclaration(
            boolean isInterface) throws ParseException {
        return astParser.ClassOrInterfaceBodyDeclaration(isInterface);
    }

}
