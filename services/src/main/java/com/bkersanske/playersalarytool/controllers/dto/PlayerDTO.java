package com.bkersanske.playersalarytool.controllers.dto;

import com.bkersanske.playersalarytool.domain.Player;

/**
 * @author bkersanske
 * @since 11/08/15 08:57
 */
public class PlayerDTO {

    public String pid;

    public Boolean isDisabledFromDrafting;

    public String atid;

    public String atabbr;

    public String htid;

    public String htabbr;

    public String fn;

    public String ln;

    public String pn;

    public Double s;

    public PlayerDTO(Player player) {
        this.pid = player.getId();
        this.isDisabledFromDrafting = player.getDisabledFromDrafting();
        this.atid = player.getNextGame().getAwayTeam().getId();
        this.atabbr = player.getNextGame().getAwayTeam().getAbbreviation();
        this.htid = player.getNextGame().getHomeTeam().getId();
        this.htabbr = player.getNextGame().getHomeTeam().getAbbreviation();
        this.fn = player.getFirstName();
        this.ln = player.getLastName();
        this.pn = player.getPositionName();
        this.s = player.getSalary();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Boolean getIsDisabledFromDrafting() {
        return isDisabledFromDrafting;
    }

    public void setIsDisabledFromDrafting(Boolean isDisabledFromDrafting) {
        this.isDisabledFromDrafting = isDisabledFromDrafting;
    }

    public String getAtid() {
        return atid;
    }

    public void setAtid(String atid) {
        this.atid = atid;
    }

    public String getAtabbr() {
        return atabbr;
    }

    public void setAtabbr(String atabbr) {
        this.atabbr = atabbr;
    }

    public String getHtid() {
        return htid;
    }

    public void setHtid(String htid) {
        this.htid = htid;
    }

    public String getHtabbr() {
        return htabbr;
    }

    public void setHtabbr(String htabbr) {
        this.htabbr = htabbr;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public Double getS() {
        return s;
    }

    public void setS(Double s) {
        this.s = s;
    }

}
