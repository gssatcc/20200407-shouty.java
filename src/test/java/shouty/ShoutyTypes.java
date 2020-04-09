package shouty;

import cucumber.api.TypeRegistry;
import io.cucumber.cucumberexpressions.CaptureGroupTransformer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

import java.util.Locale;

import static java.lang.Integer.parseInt;

public class ShoutyTypes implements cucumber.api.TypeRegistryConfigurer {
    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {

        typeRegistry.defineDataTableType(new DataTableType(PersonLocation.class,

                (TableEntryTransformer<PersonLocation>) row -> {
                    String name = row.get("name");
                    int x  = Integer.parseInt(row.get("x"));
                    int y  = Integer.parseInt(row.get("y"));
                    return new PersonLocation(name, x, y);
                }));
    }
}
