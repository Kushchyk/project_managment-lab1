async function updateStatus() {
    try {
        const response = await fetch('/game/status');
        const data = await response.json();

        // Вивід даних у консоль для дебагінгу
        console.log("Отримані дані з сервера:", data);

        // Оновлення інтерфейсу
        document.getElementById('stressLevel').textContent = data.stressLevel;
        document.getElementById('coffeeLevel').textContent = data.coffeeLevel;
        document.getElementById('sleepLevel').textContent = data.sleepLevel;
        document.getElementById('knowledgeLevel').textContent = data.knowledgeLevel;

        // Перевірка стану та вивід повідомлень
        if (data.panic) {
            console.warn("Паніка! Студент не може продовжувати навчання.");
            document.getElementById('message').textContent = "Програш! У студента паніка! Він відраховується!";
        } else if (data.expelled) {
            console.error("Студента відраховано!");
            document.getElementById('message').textContent = "Студента відраховано!";
        } else {
            console.log("Стан студента нормальний.");
            document.getElementById('message').textContent = "";
        }
    } catch (error) {
        console.error("Помилка при отриманні даних:", error);
    }
}

async function study() {
    console.log("Користувач натиснув 'Вчитися'");
    await fetch('/game/study', { method: 'POST' });
    await updateStatus();
}

async function drinkCoffee() {
    console.log("Користувач натиснув 'Пити каву'");
    await fetch('/game/drinkCoffee', { method: 'POST' });
    await updateStatus();
}

async function sleep() {
    console.log("Користувач натиснув 'Спати'");
    await fetch('/game/sleep', { method: 'POST' });
    await updateStatus();
}

async function reset() {
    console.log("Користувач натиснув 'Почати спочатку'");
    await fetch('/game/reset', { method: 'POST' });
    await updateStatus();
}

// Оновлюємо статус при завантаженні сторінки
document.addEventListener('DOMContentLoaded', updateStatus);