package org.example.filters;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

import java.io.PrintWriter;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

/**
 *
 * @author Pavel.Stepanov
 */
public class ExampleResponseWrapper extends HttpServletResponseWrapper{

    private final PrintWriter printWriter;

    public ExampleResponseWrapper(HttpServletResponse response, PrintWriter printWriter) {
        super(response);
        this.printWriter = printWriter;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return printWriter;
    }

}
