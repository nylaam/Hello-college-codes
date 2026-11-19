async function api(endpoint = '', options = {}) {
  const response = await fetch(`/api/kosakata${endpoint}`, {
    ...options,
    headers: { 'Content-Type': 'application/json', ...options.headers },
    body: options.body ? JSON.stringify(options.body) : undefined,
  });
  const payload = response.status === 204 ? null : await response.json();
  if (!response.ok) {
    const message = payload?.errors?.join(' ') || payload?.error || 'Terjadi kesalahan.';
    throw new Error(message);
  }
  return payload;
}
window.api = api;
