async function updateStatus() {
    try {
        const response = await fetch('/game/status');
        const data = await response.json();

        // Оновлення інтерфейсу
        document.getElementById('stressLevel').textContent = data.stressLevel;
        document.getElementById('coffeeLevel').textContent = data.coffeeLevel;
        document.getElementById('sleepLevel').textContent = data.sleepLevel;
        document.getElementById('knowledgeLevel').textContent = data.knowledgeLevel;

        // Перевірка стану та вивід повідомлень
        if (data.panic) {
            document.getElementById('message').textContent = "Програш! У студента паніка! Він відраховується!";
        } else if (data.expelled) {
            document.getElementById('message').textContent = "Студента відраховано!";
        } else {
            document.getElementById('message').textContent = "";
        }
    } catch (error) {
        console.error("Помилка при отриманні даних:", error);
    }
}

async function study() {
    await fetch('/game/study', { method: 'POST' });
    await updateStatus();
}

async function drinkCoffee() {
    await fetch('/game/drinkCoffee', { method: 'POST' });
    await updateStatus();
}

async function sleep() {
    await fetch('/game/sleep', { method: 'POST' });
    await updateStatus();
}

async function reset() {
    await fetch('/game/reset', { method: 'POST' });
    await updateStatus();
}

// Оновлюємо статус при завантаженні сторінки
document.addEventListener('DOMContentLoaded', updateStatus);