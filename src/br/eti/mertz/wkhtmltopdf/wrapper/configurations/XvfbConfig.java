package br.eti.mertz.wkhtmltopdf.wrapper.configurations;

import java.util.ArrayList;
import java.util.List;

import br.eti.mertz.wkhtmltopdf.wrapper.params.Param;
import br.eti.mertz.wkhtmltopdf.wrapper.params.Params;

public class XvfbConfig {

    private String command;
    private Params params;

    public XvfbConfig(String command) {
        this.command = command;
        params = new Params();
    }

    public XvfbConfig() {
        command = "xvfb-run";
        params = new Params();
    }

    public void addParams(Param... params) {
        for (Param param : params) {
            this.params.add(param);
        }
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public List<String> getCommandLine() {
        List<String> commandLine = new ArrayList<String>();

        commandLine.add(getCommand());
        commandLine.addAll(params.getParamsAsStringList());

        return commandLine;
    }

}
