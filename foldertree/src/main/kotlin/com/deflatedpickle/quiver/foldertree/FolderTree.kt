package com.deflatedpickle.quiver.foldertree

import com.deflatedpickle.haruhi.api.plugin.Plugin
import com.deflatedpickle.haruhi.api.plugin.PluginType
import com.deflatedpickle.haruhi.event.EventPanelFocusGained
import com.deflatedpickle.quiver.backend.event.EventCreateFile
import com.deflatedpickle.quiver.backend.util.DocumentUtil

@Suppress("unused")
@Plugin(
    value = "folder_tree",
    author = "DeflatedPickle",
    version = "1.0.0",
    description = """
        <br>
        Provides a panel on which a given file can be configured
    """,
    type = PluginType.COMPONENT,
    component = Component::class
)
object FolderTree {
    init {
        EventCreateFile.addListener {
            Tree.refreshAll()
        }

        EventPanelFocusGained.addListener {
            if (DocumentUtil.current != null) {
                Tree.refreshAll()
            }
        }
    }
}