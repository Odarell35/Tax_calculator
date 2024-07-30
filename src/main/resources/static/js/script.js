document.addEventListener("DOMContentLoaded", function () {
  // Tabs
  const tabs = document.querySelector(".tabs");
  const panels = document.querySelectorAll(".panel");
  tabs.addEventListener("click", (e) => {
    if (e.target.tagName == "LI") {
      const targetPanel = document.querySelector(e.target.dataset.target);
      Array.from(panels).forEach((panel) => {
        if (panel == targetPanel) {
          panel.classList.add("active");
        } else {
          panel.classList.remove("active");
        }
      });
    }
  });
});
