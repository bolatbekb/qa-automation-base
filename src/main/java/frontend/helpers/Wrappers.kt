package frontend.helpers

import com.codeborne.selenide.Selectors
import org.openqa.selenium.By
import java.nio.channels.Selector

fun byTarget(target: String): By {
    return Selectors.by("data-target", target)
}

fun byTargetId(target: String): By {
    return Selectors.by("data-target-id", target)
}

fun byKeyventId(keyvent: String): By {
    return Selectors.by("data-dev-keyvent-id", keyvent)
}

fun byDataHandler(dataHandler: String): By {
    return Selectors.by("data-handler", dataHandler)
}

fun byDataSeId(dataSeId: String): By {
    return Selectors.by("data-se-id", dataSeId)
}