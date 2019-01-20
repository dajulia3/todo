/// <reference types="Cypress" />
describe("Managing Todos Journey Test", function () {

    it("create a todo", () => {
        cy.visit("/");
        cy.get("[data-test=topics-heading]");
        cy.get("[data-test=new-topic-link]").click();
        cy.location("pathname").should("equal", "/new-topic");

        cy.get("[data-test=topic-form] [name=title]")
            .type("Get groceries");
        cy.get("[data-test=topic-form] [name=description]")
            .type("I have to get almond milk and kale.");

        cy.get("[data-test=topic-form] [data-test=submit]").click();

        cy.location("pathname").should("equal", "/");
        cy.contains("Get groceries");
        cy.contains("I have to get almond milk and kale.");

    });

    it("upvote a todo", () => {
        cy.get("[data-test=topic-votes]").contains("0");
        cy.get("[data-test=topic-upvote]").click();
        cy.get("[data-test=topic-votes]").contains("1");
    });

    it("edits a todo", () =>{
        cy.get("[data-test=todo-edit]").click();

        cy.get("[data-test=topic-form] [name=title]")
            .should("have.value", "Get groceries")
            .clear()
            .type("Tidy up");
        cy.get("[data-test=topic-form] [name=description]")
            .should("have.value", "I have to get almond milk and kale.")
            .clear()
            .type("The apartment is a mess. I need to clean up.");

        cy.get("[data-test=topic-form] [data-test=submit]")
            .click();

        cy.contains("Tidy up");
        cy.contains("The apartment is a mess. I need to clean up.");
    });

    it("deletes the todo", () => {
        cy.get("[data-test=topic-item]").should("have.length", 1);

        cy.get("[data-test=topic-delete]").click();

        cy.get("[data-test=topic-item]").should("have.length", 0);
    })
});