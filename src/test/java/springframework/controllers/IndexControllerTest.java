package springframework.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import springframework.domain.Recipe;
import springframework.services.RecipeService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        controller = new IndexController(recipeService);
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        //Verifying getIndexPage is returning "index" using MockMVC
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }

    @Test
    public void getIndexPage() {

        //GIVEN
        Set<Recipe> recipes = new HashSet<>();
        //first Recipe
        recipes.add(new Recipe());
        //second Recipe
        Recipe recipe = new Recipe();
        recipe.setId(1l);
        recipes.add(recipe);

        Mockito.when(recipeService.getRecipes()).thenReturn(recipes);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        //WHEN
        String viewName = controller.getIndexPage(model);

        //THEN
        //Verifying getIndexPage is returning "index".
        assertEquals("index", viewName);

        //Verifying recipeService.getRecipes() is executed ONE time.
        Mockito.verify(recipeService, Mockito.times(1)).getRecipes();

        //Verifying model.getRecipes() is executed ONE time, and his parameters are "recipes" and a Set.
        Mockito.verify(model, Mockito.times(1)).addAttribute(Mockito.eq("recipes"),argumentCaptor.capture());

        //Verifying recipes has TWO recipes.
        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());



    }
}